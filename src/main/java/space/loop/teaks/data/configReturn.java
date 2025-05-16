package space.loop.teaks.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.List;

public record configReturn(List<String> configAsList, JsonObject rootObject, File configFile, Gson json) {}
