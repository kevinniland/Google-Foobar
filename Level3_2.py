cache = {}


def solution(n):
    return get_possible_stairs(0, n) - 1


def get_possible_stairs(start, remaining_bricks):
    if (start, remaining_bricks) not in cache:
        if remaining_bricks == 0:
            cache[(start, remaining_bricks)] = 1
        elif remaining_bricks <= start:
            cache[(start, remaining_bricks)] = 0
        else:
            cache[(start, remaining_bricks)] = reduce(lambda accumulator, current_item: accumulator + get_possible_stairs(current_item, remaining_bricks - current_item), range(start + 1, remaining_bricks + 1), 0)

    return cache[(start, remaining_bricks)]
