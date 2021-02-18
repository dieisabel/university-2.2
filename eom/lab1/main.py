from utils import convert_to_decimal
from utils import convert_to_base


def main() -> None:
    number = input('Enter number: ')
    from_base = int(input('Enter from base: '))
    to_base = int(input('Enter to base: '))
    result = convert_to_base(convert_to_decimal(number, from_base), to_base)
    print('Result: ' + result)


if __name__ == '__main__':
    main()
