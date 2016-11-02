package ua.service.implementation;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ua.entity.CommodityOrder;

@Service
public class OrderMailServiceImpl {

    @Autowired
    private JavaMailSender mailSender;

    public void setMailSender(JavaMailSender mailSender) {
	this.mailSender = mailSender;
    }

    @Async
    public void sendOrderDetailsToUser(final CommodityOrder order) {

	MimeMessagePreparator preparator = new MimeMessagePreparator() {

	    public void prepare(MimeMessage mimeMessage) throws Exception {

		mimeMessage.setRecipient(Message.RecipientType.TO,
			new InternetAddress(order.getUser().getMail()));
		mimeMessage.setFrom(new InternetAddress(
			"e-shop-support@e-shop.com"));
		mimeMessage.setSubject("���� ����������");
		mimeMessage.setText(
		"�������� " + order.getUser().getFullName()
			+ ", ������ �� ���� ����������. ����� ���������� "
			+ order.getId() + " ���� ���������� " + order.getSum() + " ���.");
	    }
	};

	try {
	    this.mailSender.send(preparator);
	} catch (MailException ex) {
	    System.err.println(ex.getMessage());
	}
    }
    
    @Async
    public void sendOrderDetailsToAdmin(final CommodityOrder order) {

	MimeMessagePreparator preparator = new MimeMessagePreparator() {

	    public void prepare(MimeMessage mimeMessage) throws Exception {

		mimeMessage.setRecipient(Message.RecipientType.TO,
			new InternetAddress("zed180881@gmail.com"));
		mimeMessage.setFrom(new InternetAddress(
			"e-shop-support@e-shop.com"));
		mimeMessage.setSubject("���� ����������");
		mimeMessage.setText(
		"����� � ��� ���� ����������. ����� ���������� "
			+ order.getId() + " ���� ���������� " + order.getSum() + " ���.");
	    }
	};

	try {
	    this.mailSender.send(preparator);
	} catch (MailException ex) {
	    System.err.println(ex.getMessage());
	}
    }
}
