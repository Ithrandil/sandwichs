package fr.wildcodeschool.sandwichs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Menu implements CommandLineRunner {
	
	private Logger LOG = LoggerFactory.getLogger("Jambon-beurre");
	
	@Autowired
	private SandwichRepository sandwichRepository;
	
	@Override
	public void run(String...args) throws Exception{
		
        LOG.info("******************");
        LOG.info("Nombre de sandwichs au menu : " + sandwichRepository.count());

        Sandwich sandwich1 = new Sandwich("Italien", "Jambon cru, roquette, parmesan, tomates confites", 400);
        LOG.info("******************");
        LOG.info(sandwich1 + " has been created !");
        sandwichRepository.save(sandwich1);
        LOG.info(sandwich1 + " has been saved !");

        Sandwich sandwich2 = new Sandwich("Boeuf", "boeuf seché, comté, moutarde à l'ancienne, roquette", 480);
        LOG.info("******************");
        LOG.info(sandwich2 + " has been created !");
        sandwichRepository.save(sandwich2);
        LOG.info(sandwich2 + " has been saved !");


        Sandwich tempSandwich = sandwichRepository.findById(2L).get(); /* On écrit "2L" car 
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Second user's firstName is " + tempSandwich.getNom());
        LOG.info("Second user's lastName is " + tempSandwich.getIngrédients());
        LOG.info("Second user's age is " + tempSandwich.getCalories());

        LOG.info("******************");
        LOG.info("Users in list are ");
        for(Sandwich mySandwich : sandwichRepository.findAll()) {
            LOG.info(mySandwich.toString());
        };

        sandwichRepository.deleteById(2L); 
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(Sandwich mySandwich : sandwichRepository.findAll()) {
            LOG.info(mySandwich.toString());
        };
    }    
}