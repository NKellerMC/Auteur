from pathlib import Path

files = [
    "build.gradle",
    "settings.gradle"
]

for file in files:
    p = Path(file)
    txt = p.read_text(encoding="utf-8")
    txt = txt.replace("modid", "auteur")
    p.write_text(txt, encoding="utf-8")

print("Substituição concluída.")
