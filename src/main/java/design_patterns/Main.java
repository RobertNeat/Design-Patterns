package design_patterns;

import design_patterns.behawioralne.iterator.IteratorMain;
import design_patterns.behawioralne.komenda.CommandMain;
import design_patterns.behawioralne.stan.StateMain;
import design_patterns.behawioralne.mediator.MediatorMain;
import design_patterns.behawioralne.metoda_szablonowa.TemplateMethodMain;
import design_patterns.behawioralne.obserwator.ObserverMain;
import design_patterns.behawioralne.odwiedzający.VisitorMain;
import design_patterns.behawioralne.pamiątka.MementoMain;
import design_patterns.behawioralne.strategia.StrategyMain;
import design_patterns.behawioralne.łańcuch_zobowiązań.ChainOfResponsibilityMain;
import design_patterns.kreacyjne.budowniczy.BuilderMain;
import design_patterns.kreacyjne.fabryka_abstrakcyjna.AbstractFactoryMain;
import design_patterns.kreacyjne.metoda_wytwórcza.FactoryMethodMain;
import design_patterns.kreacyjne.prototyp.PrototypeMain;
import design_patterns.kreacyjne.singleton.SingletonMain;
import design_patterns.strukturalne.adapter.AdapterMain;
import design_patterns.strukturalne.dekorator.DecoratorMain;
import design_patterns.strukturalne.fasada.FacadeMain;
import design_patterns.strukturalne.kompozyt.CompositeMain;
import design_patterns.strukturalne.most.BridgeMain;
import design_patterns.strukturalne.pełnomocnik.ProxyMain;
import design_patterns.strukturalne.pyłek.FlyweightMain;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Runnable> patterns = new HashMap<>();
        //Wzorce kreacyjne
        patterns.put("factory_mathod", FactoryMethodMain::run);
        patterns.put("abstract_factory", AbstractFactoryMain::run);
        patterns.put("builder",BuilderMain::run);
        patterns.put("prototype", PrototypeMain::run);
        patterns.put("singleton", SingletonMain::run);
        //Wzorce strukturalne
        patterns.put("adapter", AdapterMain::run);
        patterns.put("bridge", BridgeMain::run);
        patterns.put("composite", CompositeMain::run);
        patterns.put("decorator", DecoratorMain::run);
        patterns.put("facade", FacadeMain::run);
        patterns.put("flyweight", FlyweightMain::run);
        patterns.put("proxy", ProxyMain::run);
        //Wzorce behawioralne
        patterns.put("chain_of_responsibility", ChainOfResponsibilityMain::run);
        patterns.put("command", CommandMain::run);
        patterns.put("iterator", IteratorMain::run);
        patterns.put("mediator", MediatorMain::run);
        patterns.put("memento", MementoMain::run);
        patterns.put("observer", ObserverMain::run);
        patterns.put("state", StateMain::run);
        patterns.put("strategy", StrategyMain::run);
        patterns.put("template_method", TemplateMethodMain::run);
        patterns.put("visitor", VisitorMain::run);

        //run builder from code
        //Runnable builder = BuilderMain::run;
        //builder.run();

        //get design-pattern from arg
        if(args.length>0){
            for(String val:args){
                if(patterns.containsKey(val)){
                    patterns.get(val).run();
                }
            }
        }
    }
}
