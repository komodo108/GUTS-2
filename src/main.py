import random, os.path
import pygame
from pygame.locals import *
from constants import *
import assets
from map import Map
from score import Score

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
        for x in range(0, SCREEN.width, assets.images['bg'].get_width()):
            self.background.blit(assets.images['bg'], (x, 0))
        self.screen.blit(self.background, (0, 0))
        pygame.display.flip()

        # load the sound effects
        if pygame.mixer:
            self.music = os.path.join(assets.main_dir, "../data", "house_lo.wav")
            pygame.mixer.music.load(self.music)
            pygame.mixer.music.play(-1)

# see if we can load more than standard BMP
if not pygame.image.get_extended():
    raise SystemExit("Sorry, extended image module required")

def main():
    setup = Setup()

    # Initialize Game Groups
    all = pygame.sprite.RenderUpdates()

    # assign default groups to each sprite class
    Map.images = [assets.images['map']]
    Map.containers = all

    # Create Some Starting Values
    clock = pygame.time.Clock()

    # initialize our starting sprites
    map = Map()
    score = Score()
    all.add(score)

    while True:
        # get input
        for event in pygame.event.get():
            if event.type == MOUSEBUTTONDOWN and event.button == 1:
                map.dragging = True

            if event.type == MOUSEMOTION:
                if map.dragging:
                    mouse_x, mouse_y = event.pos
                    map.mouseMove(mouse_x, mouse_y)
                    score.score += 1

            if event.type == MOUSEBUTTONUP:
                map.dragging = False

            if event.type == QUIT or (event.type == KEYDOWN and event.key == K_ESCAPE):
                return

        # clear/erase the last drawn sprites
        all.clear(setup.screen, setup.background)

        # update all the sprites
        all.update()

        # draw the scene
        dirty = all.draw(setup.screen)
        pygame.display.update(dirty)

        # cap the framerate
        clock.tick(40)

    if pygame.mixer:
        pygame.mixer.music.fadeout(1000)
    pygame.time.wait(1000)
    pygame.quit()

# call the "main" function if running this script
if __name__ == "__main__":
    main()