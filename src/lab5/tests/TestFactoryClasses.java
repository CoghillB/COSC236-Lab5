package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.AudioBookFactory;
import lab5.Ebook;
import lab5.EbookFactory;
import lab5.PaperBook;
import lab5.PaperBookFactory;

class TestFactoryClasses {
	
	private PaperBookFactory pbf;
	private AudioBookFactory abf;
	private EbookFactory ebf;

    @BeforeEach
    void setUp() throws Exception {
        this.pbf = new PaperBookFactory();
        this.abf = new AudioBookFactory();
        this.ebf = new EbookFactory();
    }
	
	
	@Test
	void makePaperBook() {
		assertTrue(pbf.createBook("Dune") instanceof PaperBook);
	}
	
	@Test
	void makeAudioBook() {
		assertTrue(abf.createBook("Dune") instanceof AudioBook);
	}
	
	@Test
	void makeEbook() {
		assertTrue(ebf.createBook("Dune") instanceof Ebook);
	}

}
