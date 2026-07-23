//
//  ChatViewModel.swift
//  pasaj
//

import Foundation
import Observation

@Observable
final class ChatViewModel {
    var messages: [ChatMessage] = []
    var inputText: String = ""
    var isSending = false
    var errorMessage: String?

    private let client = GeminiAPIClient.shared

    func send() async {
        let trimmed = inputText.trimmingCharacters(in: .whitespacesAndNewlines)
        guard !trimmed.isEmpty else { return }

        messages.append(ChatMessage(role: .user, text: trimmed))
        inputText = ""
        isSending = true
        errorMessage = nil

        do {
            let reply = try await client.sendMessage(history: messages)
            messages.append(ChatMessage(role: .assistant, text: reply))
        } catch {
            errorMessage = error.localizedDescription
        }

        isSending = false
    }
}
