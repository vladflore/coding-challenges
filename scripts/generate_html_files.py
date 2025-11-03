import os
import sys
import markdown

EXCLUDE_MD_FILES = ["README.md"]

FOLDER_PATH = os.path.expanduser("~/dev/sandbox/coding-challenges/")

md_file = sys.argv[1] if len(sys.argv) > 1 else None


def generate_html_file_path(md_filename):
    base_name = os.path.splitext(md_filename)[0]
    html_filename = f"{base_name}.html"
    return os.path.join(FOLDER_PATH, html_filename)


if md_file:
    if not md_file.endswith(".md"):
        print("Please provide a valid markdown (.md) file.")
        sys.exit(1)

    md_path = os.path.join(FOLDER_PATH, md_file)

    if not os.path.isfile(md_path):
        print(f"File {md_file} does not exist in the specified folder.")
        sys.exit(1)

    with open(md_path, "r") as f:
        md_content = f.read()
        html = markdown.markdown(md_content)

    with open(html_filename := generate_html_file_path(md_file), "w") as f:
        f.write(html)
        print(f"Created: {html_filename}")
else:
    for filename in os.listdir(FOLDER_PATH):
        if filename.endswith(".md") and filename not in EXCLUDE_MD_FILES:
            md_path = os.path.join(FOLDER_PATH, filename)

            with open(md_path, "r") as f:
                md_content = f.read()
                html = markdown.markdown(md_content)

            with open(html_filename := generate_html_file_path(filename), "w") as f:
                f.write(html)
                print(f"Created: {html_filename}")
