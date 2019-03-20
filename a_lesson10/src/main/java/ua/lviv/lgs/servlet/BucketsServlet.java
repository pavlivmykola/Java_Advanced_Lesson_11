package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Jornals;
import ua.lviv.lgs.domain.Subscriptions;
import ua.lviv.lgs.dto.BucketDto;
import ua.lviv.lgs.service.JornalsService;
import ua.lviv.lgs.service.SubscriptionService;
import ua.lviv.lgs.service.impl.JornalsServiceImpl;
import ua.lviv.lgs.service.impl.SubscriptionServiceImpl;

@WebServlet(name = "buckets", description = "buckets", urlPatterns = { "/buckets" })
public class BucketsServlet extends HttpServlet {

	private SubscriptionService bucketService = SubscriptionServiceImpl.getSubscriptionServiceImpl();
	private JornalsService jornalService = JornalsServiceImpl.getJornalsServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subscriptions> buckets = bucketService.readAll();
		Map<Integer,Jornals> idToProduct = jornalService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(buckets,idToProduct);
		String json = new Gson().toJson(listOfBucketDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	
	public List<BucketDto> map(List<Subscriptions> buckets, Map<Integer,Jornals> idToProduct){
		return buckets.stream().map(bucket->{
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucket_id = bucket.getId();
			bucketDto.start = bucket.getStart();
			bucketDto.end = bucket.getEnd();
			
			Jornals jornal = idToProduct.get(bucket.getJornal_id());
			bucketDto.name = jornal.getName();
			bucketDto.description = jornal.getDescription();
			bucketDto.price = jornal.getPrice();
			
			return bucketDto;
		}).collect(Collectors.toList());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
