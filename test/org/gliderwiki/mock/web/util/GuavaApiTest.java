/**
 * @FileName  : GuavaApiTest.java
 * @Project   : NightHawk
 * @Date      : 2012. 7. 12.
 * @작성자      : @author bluepoet

 * @변경이력    :
 * @프로그램 설명 :
 */
package org.gliderwiki.mock.web.util;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * @author bluepoet
 *
 */
public class GuavaApiTest {
	Logger logger = LoggerFactory.getLogger(GuavaApiTest.class);

	@Test
	public void SplitterTest() {
		Iterable<String> result = Splitter.on(',').trimResults().omitEmptyStrings().split("1, ,2 ,3 ");
		Iterator<String> iter = result.iterator();
		List<String> newResult = Lists.newArrayList();

		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println("얻어진 결과 : " + s);
			newResult.add(s);
		}

		assertThat(newResult.get(1), is("2"));
		assertThat(newResult.size(), is(3));
	}
}