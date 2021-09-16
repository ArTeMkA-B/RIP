def field(items, *args):
    assert len(args) > 0
    if len(args) == 1:
        for item in items:
            result = item.get(args[0])
            if result is not None:
                yield result
    else:
        for item in items:
            result = {key: item.get(key) for key in args if item.get(key) is not None}
            if result != {}:
                yield result


if __name__ == '__main__':
    lst = [
        {'a': 1, 'b': 2, 'c': 3},
        {'a': 2, 'c': None, 'd': -1},
        {'a': None, 'c': None, 'd': 5}
    ]

    for i in field(lst, 'a'):
        print(i)
    for i in field(lst, 'a', 'c'):
        print(i)

