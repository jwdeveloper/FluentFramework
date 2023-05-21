package io.github.jwdeveloper.ff.core.translator.api;

import io.github.jwdeveloper.ff.core.translator.api.models.LangData;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Stack;

public interface FluentTranslator
{
    String getTranslationsPath();
    String get(String key, Player player);
    String get(String key);
    LangData getDefaultLanguage();
    List<LangData> getLanguages();
    List<String> getLanguagesName();
    String getPlayerLanguage(Player player);
    boolean setDefaultLanguage(String name);
    boolean setPlayerLanguage(String name, Player player);
    boolean isLanguageExists(String name);
    boolean isLanguageDefault(String name);
}
