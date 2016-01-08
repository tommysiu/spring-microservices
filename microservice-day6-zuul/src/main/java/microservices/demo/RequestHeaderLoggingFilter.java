package microservices.demo;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class RequestHeaderLoggingFilter extends ZuulFilter {
	private static Logger logger = LoggerFactory.getLogger(RequestHeaderLoggingFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 99;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		Map<String, String> headers = ctx.getZuulRequestHeaders();

		logger.info("Request headers:");
		if (headers != null) {
			headers.forEach((key, value) -> {
				logger.info("Header[" + key + "]=[" + value + "]");
			});
		}

		return null;
	}

}
