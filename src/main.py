import random, os.path
import pygame
from pygame.locals import *
from constants import *
import assets
from map import Map
from score import Score

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