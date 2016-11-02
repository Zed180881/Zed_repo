package sia.spitter.spitterweb.view;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rometools.rome.feed.atom.Entry;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import sia.spitter.spitterdomainjpa.Spittle;

public class SpittlesAtomView extends AbstractAtomFeedView {

    @Override
    protected List<Entry> buildFeedEntries(
            Map<String, Object> model,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Spittle> spittles = (List<Spittle>) model.get("spittles");
        List<Entry> entries = new ArrayList<Entry>();
        for (Spittle spittle : spittles) {
            Entry entry = new Entry();
            entry.setTitle(spittle.getText());
            entry.setCreated(spittle.getWhen());
//            entry.setAuthors(asList(spittle.getSpitter().getFullName()));
            entries.add(entry);
        }

        return entries;
    }
}
