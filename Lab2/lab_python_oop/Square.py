from lab_python_oop.Rectangle import Rectangle


class Square(Rectangle):

    figure_name = 'Square'

    def __init__(self, width, color):
        super().__init__(width, width, color)

    @staticmethod
    def get_name():
        return Square.figure_name

    def repr(self):
        return "{}\nWidth: {}\nColor: {}\nSquare: {}".format(Square.get_name(), self.width, self.color_object.color,
                                                             self.square())
