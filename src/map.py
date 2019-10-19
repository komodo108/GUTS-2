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
        self.rect = self.image.get_rect(midbottom=SCREEN.midbottom)
        self.center = Points(self.rect.width / 2, self.rect.height / 2)

    def mouseMove(self, mouseX, mouseY):
        """Move the map in a Vector2"""
        self.rect.x = mouseX - self.center.x
        self.rect.y = mouseY - self.center.y
        self.center.x = self.rect.width / 2 - mouseX
        self.center.y = self.rect.height / 2 - mouseY
        print(self.center)
