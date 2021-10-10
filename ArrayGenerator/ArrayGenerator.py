import random
import json

def generate(count, begin, end):
    arr = []

    for i in range(count):
        arr.append(random.randint(begin, end))

    return arr


if __name__ == "__main__":
    N = int(input("Count of elements: "))
    A, B = input("Value from/to (split by space): ").split(" ")
    A = int(A)
    B = int(B)
    OUT = input("Name of output file: ")

    unsorted_arr = generate(N, A, B)
    sorted_arr = sorted(unsorted_arr)

    data = {}
    data["sorted_arr"] = sorted_arr
    data["unsorted_arr"] = unsorted_arr

    with open(OUT, "w") as f:
        json.dump(data, f)

    pass