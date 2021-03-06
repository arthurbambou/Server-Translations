package fr.catcore.server.translations.api.mixin;

import fr.catcore.server.translations.api.ServerTranslations;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ServerResourceManager;
import net.minecraft.server.command.CommandManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerResourceManager.class)
public class ServerResourceManagerMixin {

    @Shadow @Final private ReloadableResourceManager resourceManager;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void addServerLanguageManager(CommandManager.RegistrationEnvironment registrationEnvironment, int i, CallbackInfo ci) {
        this.resourceManager.registerListener(ServerTranslations.INSTANCE);
    }
}
