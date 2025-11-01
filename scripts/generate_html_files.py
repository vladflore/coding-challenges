import os

import markdown

EXCLUDE_FILES = ["README.md"]

folder_path = os.path.expanduser("~/dev/sandbox/coding-challenges/")

for filename in os.listdir(folder_path):
    if filename.endswith(".md") and filename not in EXCLUDE_FILES:
        base_name = os.path.splitext(filename)[0]
        md_path = os.path.join(folder_path, filename)
        html_filename = f"{base_name}.html"
        html_path = os.path.join(folder_path, html_filename)

        with open(md_path, "r") as f:
            md_content = f.read()
            html = markdown.markdown(md_content)
        with open(html_path, "w") as f:
            f.write(html)
        print(f"Created: {html_filename}")
