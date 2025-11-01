import os

folder_path = os.path.expanduser("~/dev/sandbox/coding-challenges/")

for filename in os.listdir(folder_path):
    if filename.endswith(".java") or filename.endswith(".py"):
        base_name = os.path.splitext(filename)[0]
        md_filename = f"{base_name}___info.md"
        md_path = os.path.join(folder_path, md_filename)
        content = f"""### Statement
{base_name}
### Solution
tbd
### Examples
tbd"""
        with open(md_path, "w") as f:
            f.write(content)
        print(f"Created: {md_filename}")
