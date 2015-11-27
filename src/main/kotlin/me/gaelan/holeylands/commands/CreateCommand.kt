package me.gaelan.holeylands.commands

import com.google.inject.Inject
import org.spongepowered.api.GameRegistry
import org.spongepowered.api.util.command.CommandResult
import org.spongepowered.api.util.command.CommandSource
import org.spongepowered.api.util.command.args.CommandContext
import org.spongepowered.api.util.command.spec.CommandExecutor
import org.spongepowered.api.world.WorldBuilder


class CreateCommand : CommandExecutor {
    @Inject lateinit var registry: GameRegistry;
    override fun execute(src: CommandSource?, args: CommandContext): CommandResult? {
        val builder = registry.createBuilder(WorldBuilder::class.java)
            .name("name")
            .build()
        return CommandResult.success()

    }
}
