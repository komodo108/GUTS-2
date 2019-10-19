import pygame
from pygame.locals import *
from constants import *

class Map(pygame.sprite.Sprite):
    # Attributes
    images = []
    dragging = False

    def __init__(self):
        """Make a new Map"""
        pygame.sprite.Sprite.__init__(self, self.containers)
        self.image = self.images[0]
        self.rect = self.image.get_rect(center=SCREEN.center)

    def startMove(self, mouseX, mouseY):
        self.start = Points(mouseX, mouseY)

    def mouseMove(self, mouseX, mouseY):
        """Move the map in a Vector2"""
        self.rect.x += self.start.x - mouseX
        self.rect.y += self.start.y - mouseY

