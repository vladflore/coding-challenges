import sys
from pathlib import Path

extension = {".py", ".java"}
exclude_dirs = {
    ".venv",
    "codeforces",
    "codewars",
    "codility",
    "coursera",
    "cracking",
    "cses",
    "dailybyte",
    "educative",
    "hackerrank",
    "leetcode",
    "others",
    "project-euler",
    "scripts",
    "taro",
}

location = sys.argv[1] if len(sys.argv) > 1 else "."

if location != ".":
    location_name = Path(location).name
    exclude_dirs.discard(location_name)

for path in Path(location).rglob("*"):
    is_right_extension = path.suffix in extension
    is_file = path.is_file()
    not_in_excluded_dirs = not any(excl in path.parts for excl in exclude_dirs)

    if is_right_extension and is_file and not_in_excluded_dirs:
        print(path)
