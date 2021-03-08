package info.kinhho.karaoke.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"","room"})
public class RoomController {
	
	private static final Log log = LogFactory.getLog(RoomController.class);
	
//	private RoomService roomService;
//	private BillService billService;
//	private FoodService foodService;
//	
//	private Bill bill;
//	
//	
//	public RoomController(RoomService roomService, BillService billService, FoodService foodService) {
//		this.roomService = roomService;
//		this.billService = billService;
//		this.foodService = foodService;
//	}
//	
	@RequestMapping(value= {"/", "/home"}, method = RequestMethod.GET)
	public String home() {
		
//		Iterable<Room> rooms = this.roomService.getRooms();		
		
//		model.addAttribute("active", "home");
//		model.addAttribute("rooms", rooms);
			
		return "room/home";
	}
//	
//	@GetMapping(value= {"price", "price/index"})
//	public String price(Model model) {
//		
//		Iterable<RoomPrice> rooms = this.roomService.getPrices(); 
//		model.addAttribute("active", "room");
//		model.addAttribute("rooms", rooms);
//		
//		return "room/price";
//		
//	}
//	
//	@GetMapping("price/add")
//	public String getAdd(Model model) {
//			
//		String actionLink = "room/price/add";
//		String actionName = "Thêm";
//		
//		model.addAttribute("actionLink", actionLink);
//		model.addAttribute("actionName", actionName);
//		model.addAttribute("active", "room");
//		model.addAttribute("room", new RoomPrice());
//		
//		return "room/edit-add";
//	}
//	
//	@PostMapping("price/add")
//	public String postAdd(RoomPrice roomPrice) {
//
//		roomService.savePrice(roomPrice);
//		
//		return "redirect:index";	
//	}
//	
//	@GetMapping("price/edit/{id}")
//	public String getEdit(@PathVariable("id") Integer id, Model model) {
//		
//		RoomPrice room = roomService.getPrice(id);
//		String actionLink = "room/price/edit";
//		String actionName = "Cập nhật";
//		
//		model.addAttribute("actionLink", actionLink);
//		model.addAttribute("actionName", actionName);
//		model.addAttribute("room", room);
//		
//		return "room/edit-add";
//	}
//	
//	@PostMapping("price/edit")
//	public String postEdit(RoomPrice room) {
//
//		roomService.updatePrice(room);			
//		return "redirect:index";
//	}
//	
//	@GetMapping("price/delete/{id}")
//	public String getDelete(@PathVariable("id") String id) {
//		
//		this.roomService.deletePrice(id);
//		return "redirect:/room/price/index";
//	}
//	
//	
//	
//	/**
//	 * 
//	 */
//	
//	@GetMapping("order/{id}")
//	public String order(@PathVariable("id") Integer id, Model model) {
//		
//		bill = new Bill();
//		Room room = roomService.getRoom(id);
//		
//		BillDetail billDetail = bill.createBillDetail(room);
//			
//		model.addAttribute("bill", bill);
//		model.addAttribute("billDetail", billDetail);
//		return "room/order";
//	}
//	
//	@PostMapping("order")
//	public String postOrder(Bill billOrdered) {
//		
//		bill.setCustomerPhone( billOrdered.getCustomerPhone() );
//		billService.setOrderForRoom(bill);
//		
//		billService.save(bill);
//		
//		return "redirect:/room/home";
//	}
//	
//	@GetMapping("use/{id}")
//	public String getUse(@PathVariable("id") Integer id) {
//		
//		billService.setUseRoom(id);
//		return "redirect:/room/home";
//	}
//	
//	@GetMapping("/swap")
//	public String getSwap(Model model) {
//		
//		Iterable<Room> usedRooms = this.roomService.getUsed();
//		Iterable<Room> unusedRooms = this.roomService.getUnused();
//		Iterable<Room> rooms = this.roomService.getRooms();		
//		
//		model.addAttribute("usedRooms", usedRooms);
//		model.addAttribute("unusedRooms", unusedRooms);
//		model.addAttribute("rooms", rooms);
//		
//		model.addAttribute("swap", new SwapRoom());
//		model.addAttribute("service", "swap");
//						
//		return "room/home";
//	}
//	
//	@PostMapping("/swap")
//	public String swap(SwapRoom swap) {
//		
//		System.err.println(swap);
//		
//		Room from = this.roomService.get(swap.getFrom());
//		Room to = this.roomService.get(swap.getTo());
//		
//		BillDetail detailFrom = this.billService.getBillDetailFromRoomId(from);
//		
//		this.roomService.setDefaultRoom(from);
//		
//		this.billService.setCheckOutForOldDetail(detailFrom);		
//		this.billService.createNewBillDetail(detailFrom, to);
//		
//		return "redirect:/room/home";
//	}
//	
//	@GetMapping("/orderfood/{id}")
//	public String getOrderFood(Model model, @PathVariable("id") Integer id) {
//		
//		Iterable<Room> rooms = this.roomService.getRooms();		
//		Iterable<Food> foods = this.foodService.get();
//		Room room = this.roomService.getRoom(id);
//
//		model.addAttribute("rooms", rooms);	
//		model.addAttribute("foods", foods);
//		model.addAttribute("service", "food");
//		
//		model.addAttribute("detailFood", new DetailFood(room.getName()));
//		return "room/home";
//	}
//	
//	@PostMapping("/orderfood")
//	@ResponseBody
//	public String postOrderFood(DetailFood detailFood) {
//		
//		Room room = this.roomService.get(detailFood.getRoomName());
//		
//		BillDetail detail = this.billService.getBillDetailFromRoomId(room);
//				
//		String listFood = detailFood.getListFood();
//		String[] arrFood_Quanlity = listFood.split(";");
//			
//		String foodId;
//		int quanlity;
//		Food food = null;
//		DetailFood detailFoodTemp;
//		
//		for (String food_quanlity : arrFood_Quanlity) {
//
//			foodId = food_quanlity.split("-")[0];
//			quanlity = Integer.parseInt(food_quanlity.split("-")[1]);
//			
//			food = this.foodService.get(foodId);
//			
//			System.out.println(detail);
//			System.out.println(food);
//			
//			detailFoodTemp = new DetailFood(detail, food, quanlity);
//			
//			detail.getDetail_foods().add(detailFoodTemp);
////			System.out.println(detailFoodTemp);
////			
////			detail.add(detailFoodTemp);
////			food.add(detailFoodTemp);	
//			
//		}
//		System.err.println(detail.getDetail_foods());
//		this.billService.save(detail);
//		return detail + " ";
//	}
}
