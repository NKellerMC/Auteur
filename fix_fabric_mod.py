import json

path = "src/main/resources/fabric.mod.json"

with open(path, "r", encoding="utf-8") as f:
    data = json.load(f)

data["id"] = "auteur"
data["name"] = "Auteur"
data["description"] = "Replay editor for Minecraft"

data["entrypoints"] = {
    "main": [
        "com.noahkeller.auteur.Auteur"
    ]
}

data.pop("mixins", None)

data["icon"] = "assets/auteur/icon.png"

with open(path, "w", encoding="utf-8") as f:
    json.dump(data, f, indent=4)

print("fabric.mod.json corrigido.")
