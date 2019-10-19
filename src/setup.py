import pygame, os.path
from pygame.locals import *
import assets
from constants import *

# global variables
class Setup():
    def __init__(self):
        # Initialize pygame
        if pygame.get_sdl_version()[0] == 2:
            pygame.mixer.pre_init(44100, 32, 2, 1024)
        pygame.init()
        if pygame.mixer and not pygame.mixer.get_init():
            print("Warning, no sound")
            pygame.mixer = None

        # Set the display mode
        bestdepth = pygame.display.mode_ok(SCREEN.size, 0, 32)
        self.screen = pygame.display.set_mode(SCREEN.size, 0, bestdepth)

        # Load images, assign to sprite classes
        # (do this before the classes are used, after screen setup)
        assets.images['map'] = assets.load_image("worldmap.jpg")

        # decorate the game window
        icon = pygame.transform.scale(assets.images['map'], (32, 32))
        pygame.display.set_icon(icon)
        pygame.display.set_caption("Pygame")

        # create the background, tile the bgd image
        assets.images['bg'] = assets.load_image("background.gif")
        self.background = pygame.Surface(SCREEN.size)

        # load the sound effects
        if pygame.mixer:
            self.music = os.path.join(assets.main_dir, "../data", "house_lo.wav")
            pygame.mixer.music.load(self.music)
            pygame.mixer.music.play(-1)