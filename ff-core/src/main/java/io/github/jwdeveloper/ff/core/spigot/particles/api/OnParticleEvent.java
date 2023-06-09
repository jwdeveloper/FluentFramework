package io.github.jwdeveloper.ff.core.spigot.particles.api;

import io.github.jwdeveloper.ff.core.spigot.particles.implementation.ParticleEvent;
import io.github.jwdeveloper.ff.core.spigot.particles.implementation.ParticleInvoker;

public interface OnParticleEvent
{
    public void execute(ParticleEvent particle, ParticleInvoker particleInvoker);
}
