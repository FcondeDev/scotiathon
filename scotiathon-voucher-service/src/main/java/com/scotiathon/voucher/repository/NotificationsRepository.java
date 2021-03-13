package com.scotiathon.voucher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scotiathon.voucher.entity.Notifications;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {

	List<Notifications> findByClientIdAndActive(Long clientId, boolean active);

}
