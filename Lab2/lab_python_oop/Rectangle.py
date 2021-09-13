from lab_python_oop.Figure import Figure
from lab_python_oop.FigureColor import FigureColor


class Rectangle(Figure):

    figure_name = 'Rectangle'

    def __init__(self, width, height, color):
        self.width = width
        self.height = height
        self.color_object = FigureColor(color)

    def square(self):
        return self.width * self.height

    @staticmethod
    def get_name():
        return Rectangle.figure_name

    def repr(self):
        return "{}\nWidth: {}\nHeight: {}\nColor: {}\nSquare: {}".format(Rectangle.get_name(), self.width, self.height,
                                                                         self.color_object.color, self.square())
