package se.sundsvall.midalva.noteapi.service;



import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.SingleInstancePostgresRule;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import se.sundsvall.midalva.noteapi.model.dto.Note;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
@Import(EmbeddedPostgresConfig.class)
public class NoteServiceIT {

    @Rule
    public SingleInstancePostgresRule pg = EmbeddedPostgresRules.singleInstance();

   private static final Logger LOG = LoggerFactory.getLogger(NoteServiceIT.class);

    @Autowired
    private NoteService noteService;

    private final static String TEST_TAG_01 = "@TestPropertySource";
    private final static String TEST_TAG_02 = "Springboot test";
    private final static String TEST_TAG_03 = "@SpringbooTest";

    @Before
    public void setUp() throws Exception {

        Note note01= new Note();
        note01.setName("How to use @SpringbooTest to test a @service");
        note01.setFormat("txt");
        note01.setContent("@SpringBootTest can be used to get access to the application.properties file");
        note01.getTags().add("Springboot test");
        note01.getTags().add(TEST_TAG_03);

        Note note02= new Note();
        note02.setName("How to use @TestPropertySource to select setup for tests");
        note02.setFormat("txt");
        note02.setContent(
                            "@TestPropertySource(\"file:src/main/resources/application-test\") " +
                            "or  @TestPropertySource(\"classpath:application-test.properties\") " +
                            "can be used to poin to the application.properties file"
        );

        note02.getTags().add(TEST_TAG_02);
        note02.getTags().add(TEST_TAG_01);

        noteService.save(note01);
        noteService.save(note02);


    }


    @Test
    public void save(){

    }

    @Test
    public void findNotesByTag() {

        final SoftAssertions softAssertions = new SoftAssertions();

        List<Note> notes01 = noteService.findNotesByTag(TEST_TAG_02);

        softAssertions.assertThat(notes01).isNotEmpty();
        softAssertions.assertThat(notes01.size()).isEqualTo(2);

        List<Note> notes02 = noteService.findNotesByTag(TEST_TAG_01);

        softAssertions.assertThat(notes02).isNotEmpty();
        softAssertions.assertThat(notes02.size()).isEqualTo(1);

        softAssertions.assertAll();

    }

    @Test
    public void getNote() {



    }
}