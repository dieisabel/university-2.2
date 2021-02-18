__all__ = ['convert_to_base', 'convert_to_decimal']


from typing import Union

from utils.checks import check_base


def convert_to_base(number: int, to_base: int) -> str:
    check_base(to_base)
    num = number
    alphabet = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    result = ''
    while num:
        num, remainder = divmod(num, to_base)
        result = alphabet[remainder] + result
    return result

def convert_to_decimal(number: Union[str, int], from_base: int) -> int:
    check_base(from_base)
    nums = [digit for digit in str(number)]
    nums.reverse()
    alphabet = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    result = 0
    for i, digit in enumerate(nums):
        for j, char in enumerate(alphabet):
            if digit == char:
                result += j * from_base ** i
                break
    return result
