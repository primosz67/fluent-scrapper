package pl.tahona.scrapper.fetcher;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

class EmailFetcher extends RegexpFetcher {

    private static final String DEFAULT_COUNTRY_CODE = "[a-zA-Z0-9-.{3}]";

    EmailFetcher(final Set<String> extensions) {
        super("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\." + getCountryCode(extensions));
    }

    private static String getCountryCode(final Set<String> extensions) {
        if (CollectionUtils.isNotEmpty(extensions)) {
            return "(" + StringUtils.join(extensions, "|") + ")";
        }
        return DEFAULT_COUNTRY_CODE;
    }

}
