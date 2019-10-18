from pygame import draw
from pygame import math

class City:

    def __init__(self):
        
        self.active = False
        self.size = 1.0

        self.loc = math.Vector2(0, 0)
    

    def draw(self, surface):
        
        draw.circle(surface, (100, 0, 100), self.loc, 10)