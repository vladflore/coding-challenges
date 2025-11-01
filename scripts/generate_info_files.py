import os

folder_path = os.path.expanduser("~/dev/sandbox/coding-challenges/")

for filename in os.listdir(folder_path):
    if filename.endswith(".java") or filename.endswith(".py"):
        base_name = os.path.splitext(filename)[0]
        txt_filename = f"{base_name}___info.txt"
        txt_path = os.path.join(folder_path, txt_filename)
        with open(txt_path, "w") as f:
            f.write(f"Dummy content for: {filename}\n")
        print(f"Created: {txt_filename}")
