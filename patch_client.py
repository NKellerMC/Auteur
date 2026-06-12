from pathlib import Path

f = Path("src/client/java/com/noahkeller/auteur/AuteurClient.java")

text = f.read_text()

# Import
if "import com.noahkeller.auteur.SaveReplayTest;" not in text:
    text = text.replace(
        "import com.noahkeller.auteur.record.RecordingManager;",
        "import com.noahkeller.auteur.record.RecordingManager;\n"
        "import com.noahkeller.auteur.SaveReplayTest;"
    )

# Troca o bloco de log
old = """
            int size = RecordingManager.RECORDER.size();
            if (size % 100 == 0) {
                Auteur.LOGGER.info("Auteur gravou {} frames", size);
            }
"""

new = """
            int size = RecordingManager.RECORDER.size();

            if (size == 400) {
                SaveReplayTest.save();
            }

            if (size % 100 == 0) {
                Auteur.LOGGER.info("Auteur gravou {} frames", size);
            }
"""

if old in text:
    text = text.replace(old, new)
else:
    print("Bloco não encontrado. Verifique o arquivo.")
    exit(1)

f.write_text(text)

print("AuteurClient.java atualizado.")
