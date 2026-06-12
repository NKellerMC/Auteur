import json

path = "src/main/resources/fabric.mod.json"

with open(path, "r", encoding="utf-8") as f:
    text = f.read()

if not text.rstrip().endswith("}"):
    text += "\n}\n"

with open(path, "w", encoding="utf-8") as f:
    f.write(text)

with open(path, "r", encoding="utf-8") as f:
    json.load(f)

print("JSON válido.")
