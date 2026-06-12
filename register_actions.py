from pathlib import Path

f = Path("src/main/java/com/noahkeller/auteur/Auteur.java")

text = f.read_text()

imports = """
import com.noahkeller.auteur.replay.action.AuteurActionRegistry;
import com.noahkeller.auteur.replay.action.ActionNextTick;
import com.noahkeller.auteur.replay.action.ActionPlayerPosition;
"""

if "AuteurActionRegistry" not in text:
    text = text.replace(
        "import org.slf4j.LoggerFactory;",
        "import org.slf4j.LoggerFactory;\n" + imports
    )

registration = """
        AuteurActionRegistry.register(
                "next_tick",
                ActionNextTick::new
        );

        AuteurActionRegistry.register(
                "player_position",
                ActionPlayerPosition::new
        );
"""

marker = 'LOGGER.info("Auteur carregado!");'

if registration.strip() not in text:
    text = text.replace(
        marker,
        marker + "\n" + registration
    )

f.write_text(text)

print("Actions registradas.")
