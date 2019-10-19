import pygame
from pygame.locals import *

SCREEN = Rect(0, 0, 800, 600)

class Points():
    def __init__(self, x, y):
        self.x = x
        self.y = y