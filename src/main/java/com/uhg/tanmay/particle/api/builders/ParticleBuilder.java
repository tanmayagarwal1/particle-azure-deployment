package com.uhg.tanmay.particle.api.builders;

import com.uhg.tanmay.particle.api.entity.Particle;
import com.uhg.tanmay.particle.api.wrappers.Wrapper;

public class ParticleBuilder {
    public static Particle builder(Wrapper wrap) {
        if (wrap.getTid() == 1) {
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Up Quark", wrap.getTid(), 2.13, 1, 2.13);
        }

        else if(wrap.getTid() == 2){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Down Quark", wrap.getTid(), 4.8, 1, 1.90);
        }

        else if(wrap.getTid() == 3){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Charm Quark", wrap.getTid(), 1.2, 1, 1.275);
        }

        else if(wrap.getTid() == 4){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Strange Quark", wrap.getTid(), -1.2, 2, 95);
        }

        else if(wrap.getTid() == 5){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Top Quark", wrap.getTid(), 0.66, 3, 173.07);
        }

        else if(wrap.getTid() == 6){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Bottom Quark", wrap.getTid(), -0.66, 3, 4.81);
        }
        return null ;
    }
}
