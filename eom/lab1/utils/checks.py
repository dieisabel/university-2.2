from typing import Optional
from typing import NoReturn


def check_base(base: int) -> Optional[NoReturn]:
    if base not in range(0, 37):
        raise ValueError('%d base unsupported' % base)
