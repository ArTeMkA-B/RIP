from lab_python_oop.Figure import Figure
from lab_python_oop.FigureColor import FigureColor
import math


class Circle(Figure):

    figure_name = 'Circle'

    def __init__(self, radius, color):
        self.radius = radius
        self.color_object = FigureColor(color)

    def square(self):
        return math.pi * self.radius ** 2

    @staticmethod
    def get_name():
        return Circle.figure_name

    def repr(self):
        return "{}\nRadius: {}\nColor: {}\nSquare: {}".format(Circle.get_name(), self.radius, self.color_object.color,
                                                              self.square())
