__all__ = ['check_base', 'check_number']


from typing import Optional
from typing import NoReturn
from typing import Union


def check_base(base: int) -> Optional[NoReturn]:
    if base not in range(2, 37):
        raise ValueError('%d base unsupported' % base)

def check_number(number: Union[str, int], base: int) -> Optional[NoReturn]:
    alphabet = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    allowed = alphabet[0:base]
    for digit in str(number):
        if digit not in allowed:
            raise ValueError('%s not in base %d' % (str(number), base))

