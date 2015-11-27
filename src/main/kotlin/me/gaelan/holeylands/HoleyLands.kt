package me.gaelan.holeylands

import com.google.inject.Inject
import me.gaelan.holeylands.commands.CreateCommand
import org.slf4j.Logger
import org.spongepowered.api.Game
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GameAboutToStartServerEvent
import org.spongepowered.api.plugin.Plugin
import org.spongepowered.api.text.Texts
import org.spongepowered.api.util.command.args.GenericArguments
import org.spongepowered.api.util.command.spec.CommandExecutor
import org.spongepowered.api.util.command.spec.CommandSpec

// Plugins are declared in basically the same way as Java.
@Plugin(id = "HoleyLands", name = "HoleyLands", version = "1.0.0")
public class HoleyLands {

    // In Kotlin, types are non-nullable by default. Normally, you would have
    // declared this value as "var game: Game?" to indicate nullability, which
    // is a bit of a pain when going to use the type -- you have to include
    // nullability checks even if the variable is injected. This nullable
    // type used to be necessary to allow a field with no value set and no
    // setter methods. In Kotlin M13, they introduced the "lateinit" keyword
    // to indicate that it's a non-nullable type, but has a value not set at
    // compile time or with a setter -- for instance, by dependency injection.
    @Inject lateinit var game: Game
    @Inject lateinit var logger: Logger

    private val createCommand = CommandSpec.builder()
            .description(Texts.of("Create a new world."))
            .arguments(GenericArguments.string("name".t()))
            .permission("holeylands.worlds.create")
            .executor(CreateCommand())
            .build()

    private val holeyLandsCommand = CommandSpec.builder()
            .description(Texts.of("Manage worlds created with HoleyLands."))
            .child(createCommand, "create", "new", "c", "n")
            .build()

    @Listener fun serverStarting(event: GameAboutToStartServerEvent) {
        game.commandDispatcher.register(this, holeyLandsCommand, "holeylands", "hl")
    }
}

