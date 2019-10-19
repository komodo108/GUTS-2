import pygame
from pygame.locals import *
from constants import *

class Score(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.font = pygame.font.Font(None, 20)
        self.font.set_italic(1)
        self.color = Color("white")
        self.prev = -1
        self.score = 0

        self.update()
        self.rect = self.image.get_rect().move(10, 450)

    def update(self):
        if self.score != self.prev:
            self.prev = self.score
            msg = "Score: %d" % self.score
            self.image = self.font.render(msg, 0, self.color)