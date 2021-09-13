from lab_python_oop.Rectangle import Rectangle
from lab_python_oop.Circle import Circle
from lab_python_oop.Square import Square
import numpy as np


def main():
    print(Rectangle(2, 2, 'blue').repr(), '\n')
    print(Circle(2, 'green').repr(), '\n')
    print(Square(2, 'red').repr(), '\n')
    print('np.ones(10) result is', np.ones(10))


if __name__ == "__main__":
    main()
