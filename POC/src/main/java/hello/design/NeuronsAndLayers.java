package com.company.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class NeuronsAndLayers {

    public static void main(String[] args) {
        SomeNeurons n1 = new Neuron();
        SomeNeurons n2 = new Neuron();
        SomeNeurons layer1 = new NeuronLayer();
        SomeNeurons layer2 = new NeuronLayer();

        n1.connect(n2);
        n2.connect(n1);

        layer1.connect(layer2);
        layer2.connect(layer1);

        layer1.connect(n1);
        layer2.connect(n2);

    }
}

interface SomeNeurons extends Iterable<Neuron> {

    default void connect(SomeNeurons someNeurons) {
        if(this == someNeurons) return;

        for(Neuron curr : this) {
            for(Neuron to : someNeurons) {
                curr.in.add(to);
                to.out.add(curr);
            }
        }
    }

}

class Neuron implements SomeNeurons {

    ArrayList<Neuron> in =  new ArrayList<>();
    ArrayList<Neuron> out =  new ArrayList<>();

    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }
}

class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons{

}