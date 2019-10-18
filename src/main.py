import random, os.path
import pygame
from pygame.locals import *
from constants import *
import assets
from map import Map
from score import Score, SCORE

# each type of game object gets an init and an
# update function. the update function is called
# once per frame, and it is when each object should
# change it's current position and state. the Player
# object actually gets a "move" function instead of
# update, since it is passed extra information about
# the keyboard

# see if we can load more than standard BMP
if not pygame.image.get_extended():
    raise SystemExit("Sorry, extended image module required")

def main(winstyle=0):
    # Initialize pygame
    if pygame.get_sdl_version()[0] == 2:
        pygame.mixer.pre_init(44100, 32, 2, 1024)
    pygame.init()
    if pygame.mixer and not pygame.mixer.get_init():
        print("Warning, no sound")
        pygame.mixer = None

    # Set the display mode
    bestdepth = pygame.display.mode_ok(SCREEN.size, winstyle, 32)
    screen = pygame.display.set_mode(SCREEN.size, winstyle, bestdepth)

    # Load images, assign to sprite classes
    # (do this before the classes are used, after screen setup)
    img = assets.load_image("player1.gif")
    Map.images = [img, pygame.transform.flip(img, 1, 0)]

    # decorate the game window
    icon = pygame.transform.scale(Map.images[0], (32, 32))
    pygame.display.set_icon(icon)
    pygame.display.set_caption("Pygame")
    pygame.mouse.set_visible(0)

    # create the background, tile the bgd image
    bgdtile = assets.load_image("background.gif")
    background = pygame.Surface(SCREEN.size)
    for x in range(0, SCREEN.width, bgdtile.get_width()):
        background.blit(bgdtile, (x, 0))
    screen.blit(background, (0, 0))
    pygame.display.flip()

    # load the sound effects
    shoot_sound = assets.load_sound("car_door.wav")
    if pygame.mixer:
        music = os.path.join(assets.main_dir, "../data", "house_lo.wav")
        pygame.mixer.music.load(music)
        pygame.mixer.music.play(-1)

    # Initialize Game Groups
    all = pygame.sprite.RenderUpdates()

    # assign default groups to each sprite class
    Map.containers = all

    # Create Some Starting Values
    clock = pygame.time.Clock()

    # initialize our starting sprites
    global SCORE
    map = Map()
    if pygame.font:
        all.add(Score())

    while map.alive():
        # get input
        for event in pygame.event.get():
            if event.type == QUIT or (event.type == KEYDOWN and event.key == K_ESCAPE):
                return
        keystate = pygame.key.get_pressed()

        # clear/erase the last drawn sprites
        all.clear(screen, background)

        # update all the sprites
        all.update()

        # handle player input
        direction = keystate[K_RIGHT] - keystate[K_LEFT]
        map.move(direction)
        firing = keystate[K_SPACE]
        if not map.reloading and firing:
            shoot_sound.play()
        map.reloading = firing

        # draw the scene
        dirty = all.draw(screen)
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