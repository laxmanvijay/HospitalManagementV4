package global.coda.hospitalmanagement.delegates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import global.coda.hospitalmanagement.models.JPAExampleTable;
import global.coda.hospitalmanagement.repository.JPAExampleTableRepository;

@Component
public class JPAExampleTableDelegate {

	@Autowired
	private JPAExampleTableRepository repo;


	public void createEntry() {
		repo.save(new JPAExampleTable(1));
	}

}
