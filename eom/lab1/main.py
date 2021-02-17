def convert_to_base(number, to_base) -> str:
    num = number
    alphabet = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    result = ''
    while num:
        num, remainder = divmod(num, to_base)
        result = alphabet[remainder] + result
    return result

def convert_to_decimal(number, from_base) -> int:
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
