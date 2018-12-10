package modello2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.EntityManagerProvider;

public class EntityManagerTest {

	@Test
	public void test() {
		EntityManagerProvider.getEntityManager();
	}

}
